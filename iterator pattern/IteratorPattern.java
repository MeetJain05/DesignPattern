
interface Iterator {
    boolean hasNext();
    Object next();
}


interface Container {
    Iterator getIterator();
}


class NameRepository implements Container {
    public String[] names = {"Alice", "Bob", "Charlie", "Diana"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    
    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            return this.hasNext() ? names[index++] : null;
        }
    }
}

public class IteratorPattern{
    public static void main(String[] args) {
        NameRepository nameRepo = new NameRepository();

        for (Iterator iter = nameRepo.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name: " + name);
        }
    }
}
