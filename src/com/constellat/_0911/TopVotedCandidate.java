package com.constellat._0911;

import java.util.HashMap;

class TopVotedCandidate {

    public int[] vote;

    public TopVotedCandidate(int[] persons, int[] times) {
        int max = 0;
        for (int time : times) {
            if (max < time) {
                max = time;
            }
        }
        vote = new int[max + 1];
        for (int i = 0; i < times.length; i++) {
            vote[times[i]] = persons[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxVoteCount = 0;
        int currentMaxVote = 0;
        for (int i = 0; i < max + 1; i++) {
            if (vote[i] != 0) {
                int count = map.getOrDefault(vote[i], 0);
                if (count + 1 >= maxVoteCount) {
                    maxVoteCount = count + 1;
                    currentMaxVote = vote[i];
                }
                vote[i] = currentMaxVote;
                map.put(vote[i], count + 1);
            }
        }
    }

    public int q(int t) {
        return vote[t];
    }

    public static void main(String[] args) {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        for (int i : topVotedCandidate.vote) {
            System.out.println(i);
        }
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */