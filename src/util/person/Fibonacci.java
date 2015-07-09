package util.person;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created with IntelliJ IDEA.
 *
 * @author olupas
 * @since 6/23/2015
 */
public class Fibonacci extends RecursiveTask<Integer> {
    final int n;

    Fibonacci(int n) {
        this.n = n;
    }

    public Integer compute() {
        System.out.println(Thread.currentThread() + "value: " + n);
        if (n <= 1)
            return n;
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        return f2.compute() + f1.join();
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer r = forkJoinPool.invoke(new Fibonacci(3));
        System.out.println(r);
    }


    static class FirstException extends Exception { }
      static class SecondException extends Exception { }

      public void rethrowException(String exceptionName) throws FirstException, SecondException {
          Exception e1;
        try {
          if (exceptionName.equals("First")) {
            throw new FirstException();
          } else {
            throw new SecondException();
          }
        } catch (Exception e) {
            e1  = e;
          throw e;
        }
      }

}