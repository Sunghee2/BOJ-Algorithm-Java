import java.io.*;

public class Main {
    public static class Stack {
        private Node lastNode;

        public Stack() {
            this.lastNode = null;
        }

        public void push(Object data) {
            Node newNode = new Node(data);
            newNode.setNextNode(lastNode);
            lastNode = newNode;
        }

        public Object pop() {
            if(isEmpty()) {
                throw new IndexOutOfBoundsException();
            } else {
                Object data = peek();
                lastNode = lastNode.getNextNode();
                return data;
            }
        }

        public Object peek() {
            if(isEmpty()) {
                throw new IndexOutOfBoundsException();
            } else {
                return lastNode.getData();
            }
        }

        public boolean isEmpty() {
            return (lastNode == null);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());

        outerloop:
        while(testcase-- > 0) {
            String str = br.readLine();
            Stack stack = new Stack();

            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '(') stack.push('(');
                try {
                    if (str.charAt(i) == ')') stack.pop();
                } catch (IndexOutOfBoundsException e) {
                    bw.write("NO\n");
                    continue outerloop;
                }
            }

            if(!stack.isEmpty()) {
                bw.write("NO\n");
                continue;
            }

            bw.write("YES\n");
        }

        bw.close();
        br.close();
    }
}

class Node {
    private Object data;
    private Node nextNode;

    public Node(Object data) {
        this.data = data;
        this.nextNode = null;
    }

    public Object getData() {
        return data;
    }

    public void setNextNode(Node node) {
        nextNode = node;
    }

    public Node getNextNode() {
        return nextNode;
    }
}