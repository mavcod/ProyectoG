package EjemploeventBus.com.org.EjemploEventBus;

import com.google.common.eventbus.Subscribe;

public abstract class AbstractListener {
	@Subscribe
    public void commonTask(String s) {
        System.out.println("do commonTask(" + s + ")");
    }

}
