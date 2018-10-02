/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algos.others;

/**
 *
 * @author anand
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Runner {
    private final HashMap<Integer, Resource> resources = new HashMap<Integer, Resource>();

    public Iterable<Resource> getResources() {
        return this.resources.values();
    }

    public Resource acquireResource(int id) {
        Resource w = this.resources.get(id);
        if (w == null) {
            w = new Resource(id);
            this.resources.put(id, w);
        }

        return w;
    }

    public void releaseResource(int id) {
        Resource w = this.resources.getOrDefault(id, null);
        if (w == null)
            throw new IllegalArgumentException();
        this.resources.remove(id);
        w.dispose();
    }

    public class Resource {
        private ArrayList<String> tasks = new ArrayList<String>();

        private int id;

        public int getId() {
            return this.id;
        }

        public Iterable<String> getTasks() {
            return this.tasks;
        }

        public Resource(int id) {
            this.id = id;
        }

        public void performTask(String task) {
            if (this.tasks == null)
                throw new IllegalStateException(this.getClass().getName());

            this.tasks.add(task);
        }

        public void dispose() {
            this.tasks = null;
        }
    }

    public static void main(String[] args) {
        Runner d = new Runner();

        d.acquireResource(1).performTask("Task11");
        d.acquireResource(2).performTask("Task21");
        System.out.println(String.join(", ", d.acquireResource(2).getTasks()));
        d.releaseResource(2);
        d.acquireResource(1).performTask("Task12");
        System.out.println(String.join(", ", d.acquireResource(1).getTasks()));
        d.releaseResource(1);
        System.out.println(d.resources);
    }
}
