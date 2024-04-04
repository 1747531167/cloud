import com.atguigu.cloud.Main8401;
import com.atguigu.cloud.contrller.FlowLimitController;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest(classes = Main8401.class)
public class test {
    @Resource
    private FlowLimitController flowLimitController;

    @Test
    public void testE() {
        int requestsCount = 20;
        CountDownLatch latch = new CountDownLatch(requestsCount);
        ExecutorService executorService = Executors.newFixedThreadPool(requestsCount);

        for (int i = 0; i < requestsCount; i++) {
            executorService.submit(() -> {
                try {
                    // 模拟请求发送
                    flowLimitController.testE();
                } finally {
                    // 每次请求完成，计数器减一
                    latch.countDown();
                }
            });
        }

        try {
            // 等待所有请求完成
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        // 关闭线程池
        executorService.shutdown();
    }
}
