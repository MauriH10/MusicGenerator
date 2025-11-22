package model;

public class Note {
    public static final int DO = 0;
    public static final int DO_ = 1;
    public static final int RE = 2;
    public static final int RE_ = 3;
    public static final int MI = 4;
    public static final int FA = 5;
    public static final int FA_ = 6;
    public static final int SOL = 7;
    public static final int SOL_ = 8;
    public static final int LA = 9;
    public static final int LA_ = 10;
    public static final int SI = 11;
    public static final int MAX_SEMITONE = 127;
    public static final int SUSTENIDO = 1;

    private final int semitone;
    private static int sustenido;

    public Note(int semitone) {
        if (semitone < 0 || semitone > MAX_SEMITONE) {
            throw new IllegalArgumentException("Semitone inválido: " + semitone);
        }
        this.semitone = semitone + Note.sustenido;
    }

    public int getSemitone() {
        return semitone;
    }

    public static int getSustenido() {
        return sustenido;
    }

    public static void setSustenido(int sustenido) {
        Note.sustenido = sustenido;
    }

    public static int charToNote(char character) {
        return switch (Character.toUpperCase(character)) {
            case 'A' -> LA;
            case 'B' -> SI;
            case 'C' -> DO;
            case 'D' -> RE;
            case 'E' -> MI;
            case 'F' -> FA;
            case 'G' -> SOL;
            case 'H' -> LA_;
            default -> -1;
        };
    }

    public static boolean isNote(char character) {
        return ('A' <= character && character<= 'H') ||
                ('a' <= character && character<= 'h');
    }
}