package Track;

public class BBRacewayJapan implements Track{
    @Override
    public void showTrackInfo() {
        System.out.println("Track Name : BB Raceway Japan");
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
