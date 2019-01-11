/**
 * 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 *
 * 명령은 총 여섯 가지이다.
 *
 * push X: 정수 X를 큐에 넣는 연산이다.
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 큐에 들어있는 정수의 개수를 출력한다.
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<Integer>();

        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    try {
                        System.out.println(queue.remove());
                    } catch(NoSuchElementException e) {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if(queue.isEmpty()) {
                        System.out.println("1");
                    } else {
                        System.out.println("0");
                    }
                    break;
                case "front":
                    if(queue.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        try {
                            System.out.println(queue.element());
                        } catch (NoSuchElementException e) {
                            System.out.println(-1);
                        }
                    }
                    break;
                case "back":
                    if(queue.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(((LinkedList<Integer>) queue).get(queue.size() - 1));
                    }
                    break;
            }
        }
    }
}

/**
 * poll()은 없으면 null 리턴 / remove()는 없으면 에러 던짐
 * peek()와 element()도 위와 마찬가지.
 *
 * https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html
 * **/