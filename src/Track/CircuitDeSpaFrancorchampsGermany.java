package Track;

public class CircuitDeSpaFrancorchampsGermany implements Track{
    @Override
    public void showTrackInfo() {
        System.out.println("Track Name : Ciruit De Spa Francorchamps Germany");
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
