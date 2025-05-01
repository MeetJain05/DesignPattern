import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void display();
}

class File implements FileSystemComponent{
    private String name;

    public File(String name){
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("File: " + name);
    }
}

class Folder implements FileSystemComponent{
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name){
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void display(){
        System.out.println("Folder: " + name);
        for(FileSystemComponent component: components){
            component.display();
        }
    }
}

public class composite {
    public static void main(String[] args){
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        Folder folder1 = new Folder("folder1");
        folder1.addComponent(file1);
        folder1.addComponent(file2);

        Folder folder2 = new Folder("folder2");
        folder2.addComponent(new File("file3.txt"));
        folder2.addComponent(folder1);

        folder2.display();
    }
}