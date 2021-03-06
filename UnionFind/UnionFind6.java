package com.wyh.unionfind;
/**
 *
 * unionfind5第六版，路径压缩,递归
 * */
public class UnionFind6 implements UF{
	private int[] parent;
	private int[] rank; //rank[i]表示以i为根的集合中所表示的树的层数
	
	public UnionFind6(int size) {
		parent=new int[size];
		rank=new int[size];
		
		for(int i=0;i<size;i++) {
			parent[i]=i;
			rank[i]=1;//在初始化中，每个元素只有以自己为根的一个深度
		}
	}
	@Override
	public int getSize() {
		return parent.length;
	}
	
	
	//查找过程，查找元素p所对应的集合编号
	//O(h)复杂度，h为树的高度
	private int find(int p) {
		if(p<0 || p>=parent.length)
			throw new IllegalArgumentException("p is out of bound.");
		if(p!=parent[p])
			parent[p]=find(parent[p]);//路径压缩，采用递归方法，直接返回父亲节点
		return parent[p];//此方法只限定索引值和对应的集合数值相同时的查找跟节点
	}
	
	
	//查看元素p和元素q是否属于一个集合
	//O(h)复杂度，h为树的高度
	@Override 
	public boolean isConnected(int p,int q) {
		return find(p)==find(q);
	}
	//合并元素p和元素q所属的集合
	//O(h)复杂度，h为树的高度
	@Override
	public void unionElements(int p,int q) {
		int pRoot=find(p);
		int qRoot=find(q);
		if(pRoot==qRoot)
			return;
		//根据两个元素所在树的rank不同判断合并方向
		//将rank低的集合合并到rank高的集合上
		if(rank[pRoot]<rank[qRoot]) //如果以pRoot为根的深度<qRoot,则将深度低的连接到多的上
			parent[pRoot]=qRoot;//连接之后的qRoot的深度不变
		else if(rank[qRoot]<rank[pRoot])
			parent[qRoot]=qRoot;
		else {//rank[qRoot]==rank[pRoot]
			parent[qRoot]=pRoot;
			rank[pRoot]+=1;//在相等时，任意合并都会导致根节点为树的深度增加1
		}
	}
}


