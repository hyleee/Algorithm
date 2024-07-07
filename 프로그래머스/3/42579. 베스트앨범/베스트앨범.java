import java.util.*;
import java.io.*;

class Genre implements Comparable<Genre>{
    String genreName;
    int totalPlay;
    public Genre(String genreName, int totalPlay){
        this.genreName= genreName;
        this.totalPlay = totalPlay;
    }
    
    // 장르 별 총 플레이 수 기준 내림차순 정렬
    @Override
    public int compareTo(Genre o){
        return o.totalPlay - this.totalPlay;
    }
}

class Song implements Comparable<Song>{
    int songId, play;
    public Song(int songId, int play){
        this.songId = songId;
        this.play = play;
    }
    
    // 노래 별 플레이 횟수 기준 내림차순
    @Override
    public int compareTo(Song o){
        return o.play - this.play;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 1) 장르 별 노래 저장
        Map<String, List<Song>> songList = new HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            // 아직 노래 저장이 안된 장르라면
            if(songList.get(genres[i])==null){
                // value자리에 새로운 list를 생성하고
                songList.put(genres[i], new ArrayList<>());
            }
            // 해당 장르의 Song (id, play) 을 저장
            songList.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        // 2) 장르 별 전체 플레이 횟수를 저장
        List<Genre> playCnt = new ArrayList<>();
        for(String gen : songList.keySet()){
            int sum=0;
            for(int i=0; i<songList.get(gen).size(); i++){
                sum += songList.get(gen).get(i).play;
            }
            playCnt.add(new Genre(gen, sum));
        }
        
        // 3) 앨범 생성
        // 플레이수 기준 장르 별 노래들을 정렬
        Collections.sort(playCnt);
        List<Integer> album = new ArrayList<>();
        for(Genre genre : playCnt){
            String gen = genre.genreName; // 이번 장르
            List<Song> genreSong = songList.get(gen); // 이번 장르에 해당하는 노래들
            // 플레이수 기준 이 장르의 노래들을 정렬
            Collections.sort(genreSong);
            int songCnt = genreSong.size();
            
            for(int j=0; j<songCnt; j++){
                if(j==2) break;
                album.add(genreSong.get(j).songId);
            }
        }
        
        // 4) 결과 출력
        int[] answer = new int[album.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = album.get(i);
        }
        
        return answer;
    }
}