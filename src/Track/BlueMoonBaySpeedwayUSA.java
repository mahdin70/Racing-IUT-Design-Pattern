package Track;

public class BlueMoonBaySpeedwayUSA implements Track{
    @Override
    public void showTrackInfo() {
        System.out.println("Track Name : Blue Moon Bay Speedway USA");
        startLine();
        finishingLine();
    }

    @Override
    public void startLine() {
        System.out.println("This is the Start Line");
    }

    @Override
    public void finishingLine() {
        System.out.println("This is the Finishing Line");
    }
}
