package behavioural;

interface Iterator{
    boolean hasnext();
    Object next();
}

interface Mycollection{
    Iterator createiterator();
}

class BooksCollection implements Mycollection{
    String[] books = {"Book1", "Book2", "Book3"};
    
    public Iterator createiterator(){
        return new BookIterator();
    }

    private class BookIterator implements Iterator{
        int index = 0 ;

        public boolean hasnext(){
            return index < books.length;
        }

        public Object next(){
            if(hasnext()){
                return books[index++];
            }
            else{
                return null;
            }
        }
    }
    
}

public class IteratorPattern {
    public static void main(String[] args) {
        BooksCollection books = new BooksCollection();
        Iterator iterator = books.createiterator();

        while(iterator.hasnext()){
            System.out.println(iterator.next());
        }
    }
}
