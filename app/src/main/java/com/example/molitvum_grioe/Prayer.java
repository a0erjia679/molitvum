package com.example.molitvum_grioe;

public class Prayer {
    private String title; // Название молитвы
    private String textRussian; // Текст молитвы на русском
    private String textChurchSlavonic; // Текст молитвы на церковнославянском
    private boolean isRussian = true; // Флаг для отслеживания текущего языка

    public Prayer(String title, String textRussian, String textChurchSlavonic) {
        this.title = title;
        this.textRussian = textRussian;
        this.textChurchSlavonic = textChurchSlavonic;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) { this.title = title; }

    public String getText() {
        return isRussian ? textRussian : textChurchSlavonic;
    }
    public String getTextRussian() { return textRussian; }
    public void setTextRussian(String textRussian) { this.textRussian = textRussian; }
    public String getTextChurchSlavonic() { return textChurchSlavonic; }
    public void setTextChurchSlavonic(String textChurchSlavonic) { this.textChurchSlavonic = textChurchSlavonic; }


    public void toggleLanguage() {
        isRussian = !isRussian; // Переключение языка
    }

}
