package com.constellat._0794;

class Solution {
    public boolean validTicTacToe(String[] board) {
        int firstNum = 0;
        int secondNum = 0;

        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            for (int charIndex = 0; charIndex < s.length(); charIndex++) {
                char ch = s.charAt(charIndex);
                if (ch == 'X') {
                    firstNum++;
                } else if (ch == 'O') {
                    secondNum++;
                }
            }
        }

        if (firstNum != secondNum && firstNum != secondNum + 1) {
            return false;
        }
        if (win(board, 'X') && firstNum != secondNum + 1) {
            return false;
        }
        if (win(board, 'O') && firstNum != secondNum) {
            return false;
        }
        return true;
    }

    public boolean win(String[] board, char p) {
        for (int i = 0; i < 3; ++i) {
            if (p == board[0].charAt(i) && p == board[1].charAt(i) && p == board[2].charAt(i)) {
                return true;
            }
            if (p == board[i].charAt(0) && p == board[i].charAt(1) && p == board[i].charAt(2)) {
                return true;
            }
        }
        if (p == board[0].charAt(0) && p == board[1].charAt(1) && p == board[2].charAt(2)) {
            return true;
        }
        if (p == board[0].charAt(2) && p == board[1].charAt(1) && p == board[2].charAt(0)) {
            return true;
        }
        return false;
    }
}