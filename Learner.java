public class Learner {
    private String name;
    private int maths;
    private int english;
    private int life;
    private double average;
    private String status;

    public Learner(String name, int maths, int english, int life) {
        this.name = name;
        this.maths = maths;
        this.english = english;
        this.life = life;
        recalculate();
    }

    private void recalculate() {
        this.average = (maths + english + life) / 3.0;
        if (average >= 50) this.status = "PASSED";
        else if (average >= 40) this.status = "SUPPLEMENTARY";
        else this.status = "FAILED";
    }

    // Getters
    public String getName() { return name; }
    public double getAverage() { return average; }
    public String getStatus() { return status; }
    public int getMaths() { return maths; }
    public int getEnglish() { return english; }
    public int getLife() { return life; }

    // Setters for EDIT feature
    public void setMaths(int maths) { this.maths = maths; recalculate(); }
    public void setEnglish(int english) { this.english = english; recalculate(); }
    public void setLife(int life) { this.life = life; recalculate(); }

    public String getReport() {
        return String.format("%s - Maths:%d Eng:%d LO:%d - %.1f - %s", name, maths, english, life, average, status);
    }

    public String toCSV() {
        return String.format("%s,%d,%d,%d,%.1f,%s", name, maths, english, life, average, status);
    }
}