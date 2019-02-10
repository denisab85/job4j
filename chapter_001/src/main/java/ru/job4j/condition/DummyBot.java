package ru.job4j.condition;

/**
 * @author Denis Abakumov
 * @version $Id$
 */
public class DummyBot {

    /**
     * Responds to a question.
     *
     * @param question inquiry phrase.
     * @return predefined response based on the question.
     */
    public String answer(String question) {
        String response;
        switch (question) {
            case "Привет, Бот.":
                response = "Привет, умник.";
                break;
            case "Пока.":
                response = "До скорой встречи.";
                break;
            default:
                response = "Это ставит меня в тупик. Задайте другой вопрос.";
                break;
        }
        return response;
    }
}
