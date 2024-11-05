package Interfaces.SmartPhone;

public class Test {
    public static void main(String[] args) {
        SmartPhone sp = new SmartPhone();

        sp.makeCall();
        sp.endCall();
        sp.playMusic();
        sp.pauseMusic();
        sp.takePicture();
        sp.recordVideo();
    }
}


/*
abstract class has instance variables and constrcutor to initialize instant variables, interface don't
one class extends only one abstract class, but multiple interfaces
 */