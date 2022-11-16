import fi.uef.cs.tra.BTree;
import fi.uef.cs.tra.BTreeNode;


import java.util.*;

public class TRAI_22_X4_dankurhi implements TRAI_22_X4 {
    
    public <E extends Comparable<? super E>> boolean onkoSisaJarjestyksessa(BTree<E> T) {

        // TODO

        BTreeNode<E> juuri = T.getRoot(); //O(1)
        Stack stack = new Stack<>(); //O(1)
        LinkedList<E> lista = new LinkedList<>(); //O(1)

        //Tyhjästä puusta palautetaan tosi.
        if (juuri == null) { //O(1)
            return true;
        }

        //Lisätään arvot pinoon ja LinkedListaan samalla kun poistetaan pinosta.
        while (juuri != null || !stack.isEmpty()) {     //O(n)
            if (juuri != null) {
                stack.push(juuri); //O(1)
                juuri = juuri.getLeftChild(); //O(1)
            } else {
                BTreeNode node = (BTreeNode) stack.pop();
                lista.add((E) node.getElement()); //O(1)
                juuri = node.getRightChild(); //O(1)
            }
        }
        //Tarkistetaan iteraattorilla, onko lista kasvavassa järjestyksessä.
        Iterator<E> iterator = lista.iterator(); //O(1)
        E iteraattorinEkaArvo = iterator.next(); //O(1)

        while (iterator.hasNext()) {    //O(n)
            E iteraattorinToinenArvo = iterator.next(); //O(1)
            if (iteraattorinEkaArvo.compareTo(iteraattorinToinenArvo) > 0) {    //O(1)
                return false;
            }
            iteraattorinEkaArvo = iteraattorinToinenArvo;   //O(1)
        }
        return true;
    }
}