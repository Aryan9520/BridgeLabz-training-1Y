interface LightAction {
    void activate();
}

public class SmartHome {
    public static void main(String[] args) {

        LightAction motionTrigger = () ->
            System.out.println("Motion Detected: Lights ON at full brightness");

        LightAction nightTrigger = () ->
            System.out.println("Night Mode: Lights ON with dim brightness");

        LightAction voiceTrigger = () ->
            System.out.println("Voice Command: Changing lights to Blue color");

        motionTrigger.activate();
        nightTrigger.activate();
        voiceTrigger.activate();
    }
}