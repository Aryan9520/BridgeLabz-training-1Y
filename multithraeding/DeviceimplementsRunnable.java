class DeviceimplementsRunnable {

    private String deviceName;
    private int interval;

    public Device(String deviceName, int interval) {
        this.deviceName = deviceName;
        this.interval = interval;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();

        for (int i = 1; i <= 5; i++) {
            System.out.println(
                "[" + java.time.LocalTime.now() + "] " +
                deviceName + " | Priority: " + t.getPriority() +
                " | Cycle: " + i
            );

            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println(deviceName + " finished execution ✅");
    }
}

public class SmartHome {
    public static void main(String[] args) {

        // Create devices
        Thread tempSensor = new Thread(new Device("Temperature Sensor", 5000));
        Thread securityCam = new Thread(new Device("Security Camera", 3000));
        Thread lightCtrl = new Thread(new Device("Light Controller", 4000));
        Thread doorLock = new Thread(new Device("Door Lock Monitor", 6000));

        // Set priorities
        securityCam.setPriority(10); // Highest
        tempSensor.setPriority(7);
        lightCtrl.setPriority(5);
        doorLock.setPriority(5);

        // Start all devices
        securityCam.start();
        tempSensor.start();
        lightCtrl.start();
        doorLock.start();

        // Wait for all threads to finish
        try {
            securityCam.join();
            tempSensor.join();
            lightCtrl.join();
            doorLock.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("🏠 Smart Home System Shut Down Successfully");
    }
}