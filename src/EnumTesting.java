enum Week { SUNDAY(10, 90), MONDAY(20, 100);
  public int mass;
  public  int ans;
  Week(int mass, int ans) {
      this.mass = mass;
      this.ans = ans;
  }
}
public class EnumTesting {
    Week week;
    EnumTesting(Week week) {
        this.week = week;
        System.out.println(week.mass);
    }

    public static void main(String[] args) {
        EnumTesting enumTesting = new EnumTesting(Week.SUNDAY);



    }

}
