//http://masudioprogramming.blogspot.no/2010/03/binary-search-tree-text-file-word.html

import java.io.*;
import java.util.Scanner;

public class one {
    
    public static void main(String [] args)throws FileNotFoundException{
        
        Node root=null;
        Scanner sc=new Scanner (new File (args [0]));
        while(sc.hasNext()){
            String ord=sc.next();
            if(root==null)
                root = new Node(ord);
            else
                root.leggTil(ord);
        }
        System.out.println(root.dybde(root));
    }
}


public class Node{
    private String ord;
    private Node left;
    private Node right;
    
    public Node(String ord){
        this.ord=ord;
    }
    public boolean leggTil(String ord){
        if(ord.equals(this.ord)){
            return false;
        }
        else if (ord.compareTo(this.ord)<0){
            if (left==null){
                left=new Node(ord);
                return true;
            } else
                return left.leggTil(ord);
        } else if(ord.compareTo(this.ord)>0){
            if (right==null){
                right=new Node (ord);
                return true;
            } else
                return right.leggTil(ord);
        }
        return false;
    }
    // Dybde
    public int dybde(Node nd){
        if(nd==null)return 0;
        return 1+Math.max(dybde(nd.left), dybde(nd.right))    ;
    }
    // Antall noder i hvert nivå
    public int levelNodes(Node root, int currentLevel, int wantedLevel){
        if (currentLevel==wantedLevel)
            return 1;
        int left=0;
        int right=0;
        if(root.left!=null)
            left=levelNodes(root.left, currentLevel+1, wantedLevel);
        if(root.right!=null)
            right=levelNodes(root.right, currentLevel+1, wantedLevel);
        return left+right;
    }
    
    //Sum av alle dybdene til node--->SJEKK???
    public int dybdeNode(Node root, int dybde, int sumDybde){
        if (root==null) {
            return 0;
        }
        
        int db=0;
        if (root.left!=null){
	   db=dybde+1;
	   sumDybde=sumDybde+db;
	   dybdeNode(root.left, db, sumDybde);
        }
        if (root.right!=null){
	   db=dybde+1;
	   sumDybde=sumDybde+db;
	   dybdeNode(root.right, db,sumDybde);
        }
        return dybde;
    }
    
    
    public int antalNoder(Node root){
        if(root==null) return 0;
        
    }
}