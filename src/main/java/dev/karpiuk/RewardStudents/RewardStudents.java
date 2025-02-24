package dev.karpiuk.RewardStudents;

import java.util.*;
import java.util.stream.Collectors;

public class RewardStudents {

    private void updateScore(Map<Integer, Integer> studentToScore, int studentId, int score) {
        studentToScore.put(studentId, studentToScore.getOrDefault(studentId, 0) + score);
    }

    private void updateScoreBasedOnFeedback(Map<Integer, Integer> studentToScore, String feedback, Set<String> positiveFeedback, Set<String> negativeFeedback, int studentId) {
        String[] words = feedback.split(" ");

        for (String word : words) {
            if (positiveFeedback.contains(word)) {
                updateScore(studentToScore, studentId, 3);
            } else if (negativeFeedback.contains(word)) {
                updateScore(studentToScore, studentId, -1);
            }
        }
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positiveFeedbackSet = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negativeFeedbackSet = new HashSet<>(Arrays.asList(negative_feedback));

        Map<Integer, Integer> studentToScore = new HashMap<>();

        for (int id : student_id) {
            studentToScore.put(id, 0);
        }

        for (int i = 0; i < report.length; i++) {
            updateScoreBasedOnFeedback(studentToScore, report[i], positiveFeedbackSet, negativeFeedbackSet, student_id[i]);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ? Integer.compare(a.getKey(), b.getKey()) : Integer.compare(b.getValue(), a.getValue())
        );

        pq.addAll(studentToScore.entrySet());

        List<Integer> topKStudentIds = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            topKStudentIds.add(pq.poll().getKey());
        }

        return topKStudentIds;
    }

    public static void main(String[] args) {
        RewardStudents rewardStudents = new RewardStudents();
        String[] positive_feedback = new String[] {"good", "excellent"};
        String[] negative_feedback = new String[] {"poor", "bad"};
        String[] report = new String[] {"good good good excellent", "poor poor poor bad", "good good good excellent"};
        int[] student_id = new int[] {1, 2, 3};
        int k = 2;
        List<Integer> result = rewardStudents.topStudents(positive_feedback, negative_feedback, report, student_id, k);
        for (Integer i : result) {
            System.out.println(i);
        }
    }

}
