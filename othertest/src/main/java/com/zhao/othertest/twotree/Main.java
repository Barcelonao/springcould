package com.zhao.othertest.twotree;

public class Main {
    public static void main(String[] args) {
        TreeNode A = new TreeNode();
        TreeNode B = new TreeNode();
        TreeNode C = new TreeNode();
        TreeNode D = new TreeNode();
        TreeNode E = new TreeNode();
        TreeNode F = new TreeNode();
        TreeNode G = new TreeNode();
        TreeNode H = new TreeNode();
        TreeNode I = new TreeNode();


        A.node = "A";
        A.LTree = B;
        A.RTree = C;


        B.node = "B";
        B.LTree = D;
        B.RTree = null;

        C.node = "C";
        C.LTree = E;
        C.RTree = F;

        D.node = "D";
        D.LTree = G;
        D.RTree = H;

        E.node = "E";
        E.LTree = null;
        E.RTree = I;

        F.node = "F";
        F.LTree = null;
        F.RTree = null;

        G.node = "G";
        G.LTree = null;
        G.RTree = null;

        H.node = "H";
        H.LTree = null;
        H.RTree = null;


        I.node = "I";
        I.LTree = null;
        I.RTree = null;

        Zhong(A);

    }

    public static void xian(TreeNode treeNode) {

        System.out.println(treeNode);

        if (treeNode.LTree != null)
            xian(treeNode.LTree);
        if (treeNode.RTree != null)
            xian(treeNode.RTree);

    }

    public static void Zhong(TreeNode treeNode) {

        if (treeNode.LTree != null)
            Zhong(treeNode.LTree);
        System.out.println(treeNode);
        if (treeNode.RTree != null)
            Zhong(treeNode.RTree);

    }
}
