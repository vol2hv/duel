package com.madv.duel;

/**
 * Сообщения выводимые на консоль
 */
public enum MessageCode {
    MSG_GAMER_NAME (new StringBuffer()
            .append("Введите Ваше имя,\n ")
            .append("Пустая строка - завершение программы.\n ")
            .append("Ваше имя: ")
            .toString()),
    MSG_ATTACKING_MOVE (new StringBuffer()
            .append("Введите номер карты для атаки,\n ")
            .append("Пустая строка - завершение программы.\n ")
            .append("Карта для атаки: ")
            .toString()),
    MSG_PROTECTIVE_MOVE(new StringBuffer()
            .append("Введите номер карты для зашиты,\n ")
            .append("Пустая строка - завершение программы.\n ")
            .append("Карта для защиты: ")
            .toString()),
    MSG_WHO_BEGIN(new StringBuffer()
            .append("Введите очередность хода,\n ")
            .append("1 - Вы начинаете 2 - начинает компьютер 3 - выбирает случай.\n ")
            .append("Пустая строка - завершение программы.\n ")
            .append("Очередь хода: ")
            .toString()),
    MSG_DIFFICULTY_LEVEL(new StringBuffer()
            .append("Выберите алгоритм стратегии игры компьютера.\n")
            .append("1 - случайный выбор 2 - крутой алгоритм\n ")
            .append("Пустая строка - завершение программы.\n ")
            .append("Алготитм стратегии: ")
            .toString()),
    MSG_PHASE_END_INFORMATION(new StringBuffer()
            .append("Карта атакующего [%d] ")
            .append("Карта защитника [%d] штраф [%d] \n ")
            .append("Атакующий: [%s] Защитник: [%s] \n ")
            .toString()),
    MSG_GAME_END_INFORMATION(new StringBuffer()
            .append("Игра завершена.\n")
            .append("Штрафные очки [%s]: %d [%s]: %d\n ")
            .toString()),
    MSG_CONTINUE_GAME(new StringBuffer()
            .append("Вы хотите ссыграть еще один раз?\n ")
            .append("Пустая строка - завершение программы.\n")
            .append("Не пустой ввод - играем еще раз.\n ")
            .append("Играем дальше: ")
            .toString());

    private String text;
    MessageCode(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
