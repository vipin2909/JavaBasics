public class LatticePoints {
    public int countLattice(int r) {
        if(r <= 0) {
            return 0;
        }
        int result = 4;
        for(int i = 1; i < r; i++) {
            int ySquare = r*r - i*i;
            int y = (int)Math.sqrt(ySquare);

            if(y*y == ySquare) {
                result += 4;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LatticePoints latticePoints = new LatticePoints();
        int r = 5;
        System.out.println(latticePoints.countLattice(r));
    }
}
