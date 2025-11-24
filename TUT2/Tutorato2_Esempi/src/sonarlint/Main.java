package sonarlint;

public class Main {

    public static void main(String[] args) {

        System.out.println("Start app...");
        DataProcessor processor = new DataProcessor();
        ReportGenerator gen = new ReportGenerator();

        // Metodo enorme con complessità ciclom. altissima
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                processor.process("low");
            } else if (i == 1) {
                processor.process("medium");
            } else if (i == 2) {
                processor.process("high");
            } else if (i == 3) {
                processor.process("critical");
            } else if (i == 4) {
                processor.process("unknown");
            } else {
                System.out.println("This will never happen");
            }
        }

        // Dipendenza ciclica: Main → ReportGenerator → FileUtils → DataProcessor → Main
        String report = gen.generate(processor.getResults());

        System.out.println(report);

        // Dead code
        if (false) { System.out.println("Never printed"); }

        // Risorse non chiuse
        FileUtils.read("file.txt");
    }
}