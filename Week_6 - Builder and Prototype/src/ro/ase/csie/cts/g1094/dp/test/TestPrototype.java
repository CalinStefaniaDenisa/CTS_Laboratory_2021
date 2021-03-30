package ro.ase.csie.cts.g1094.dp.test;

import ro.ase.csie.cts.g1094.dp.prototype.Tree3DModel;

public class TestPrototype {

	public static void main(String[] args) throws CloneNotSupportedException {

		// inefficient
		Tree3DModel tree1 = new Tree3DModel("green", 100);
		Tree3DModel tree2 = new Tree3DModel("green", 100);
		
		// shalow-copy
		Tree3DModel anotherTree = tree1;
		
		// build multiple trees using clone
		// deep-copy
		Tree3DModel tree3 = (Tree3DModel) tree1.clone();
		Tree3DModel tree4 = (Tree3DModel) tree1.clone();
		Tree3DModel tree5 = (Tree3DModel) tree1.clone();
	}

}
