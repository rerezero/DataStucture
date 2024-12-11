import dataStructures.Chain;
public class MyChain extends Chain {
	public MyChain(int initialCapacity) {
		super(initialCapacity);
		}
	public MyChain() {
		super(0);
	}
	
	public MyChain(MyChain mychain) {
		super(mychain.size());
		for (int i = 0; i < mychain.size(); i++)
			this.add(i, mychain.get(i));
	}
	
	public Object[] toArray()
	{
		Object[] x = new Object[this.size()];
		for(int i = 0; i < this.size();i++)
			x[i] = this.get(i);
		return x;
	}
	
	public void addRange(Object[] elements)
	{
		for(int i = 0; i < elements.length; i++)
		{
			this.add(this.size(), elements[i]);	
		}
	}
	public MyChain intersectMethod1(MyChain mlist)
	{
		MyChain intersectCh = new MyChain();
		int k=0;
		for(int i=0;i<this.size();i++) {
			for(int j=0;j<mlist.size();j++) {
				if((int)this.get(i)==(int)mlist.get(j)) {
					intersectCh.add(k, mlist.get(j));
					k++;
				}
			}
					
		}
		return intersectCh;
		
	}
	public MyChain union(MyChain chain) {
        MyChain unionCh = new MyChain(this);
        for (int i = 0; i < chain.size(); i++) {
            if (!this.containsElement(unionCh, chain.get(i))) {
                unionCh.add(unionCh.size(), chain.get(i));
            }
        }
        return unionCh;
    }

    private boolean containsElement(MyChain chain, Object element) {
        for (int i = 0; i < chain.size(); i++) {
            if (chain.get(i).equals(element)) {
                return true;
            }
        }
        return false;
    }
}
