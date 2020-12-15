public class RottenPotato {

    public static void main(String[] args) {

        int[][] ratings = { {4,6,2,5},
                            {7,9,4,8},
                            {6,9,3,7} };

        System.out.println("Movie zero's average rating: " + movieAvgRating(ratings, 0));                    
        System.out.println("Movie one's average rating: " + movieAvgRating(ratings, 1));    
        System.out.println("Reviewer zero's average rating: " + reviewerAvgRating(ratings, 0));    
        System.out.println("Reviewer one's average rating: " + reviewerAvgRating(ratings, 1));
        System.out.println("Average rating for all movies in 2018: " + avgRating2018(ratings));    
        System.out.println("Hardest reviewer is #" + hardestReviewer2018(ratings));
        System.out.println("Worst movie is #" + worstMovie2018(ratings));
    }

    //Question 1
    public static double movieAvgRating(int[][] ratings, int movie) {
        double sum = 0;
        // ratings[][] is 2D array of rating by reviewer x movie (ratings[reviewer][movie])
        for (int reviewer = 0; reviewer < ratings.length; reviewer++) {
            sum += ratings[reviewer][movie];
        }

        return (sum / ratings.length);
    }

    //Question 2
    public static double reviewerAvgRating(int[][] ratings, int reviewer) {
        double rater = 0;
        for(int col = 0; col < ratings[0].length; col++){
            rater += ratings[reviewer][col];
        }
        return rater/ratings[0].length;
    }

    //Question 3
    public static double avgRating2018(int[][] ratings) {
        double avg2018 = 0;
        double n = 0;
        for (int r = 0; r < ratings.length; r++){
            for (int c = 0; c < ratings[0].length; c++){
            avg2018 += ratings[r][c];
            n++;
            }
        }
        return avg2018/n;
    }

    //Question 4
    public static int hardestReviewer2018(int[][] ratings) {
        int [] reviewersum = new int[ratings.length];

        for(int row = 0; row < ratings.length; row++){
            int total = 0;
            for(int col = 0; col < ratings[0].length; col++){
                total += ratings[row][col];
            }
            reviewersum[row] = total;
        }
        
        // loop through the moviesum 1-D array and see which movie has lowest review
        int lowReviewer = -1;
        int lowReviewerSum = 999;
        for (int i = 0; i < reviewersum.length; i++) {
            if (i == 0 || lowReviewerSum < lowReviewerSum) {
                lowReviewer = i;
                lowReviewerSum = reviewersum[i]; 
            }
        }       
        
        return lowReviewer;
        
    }

    //question 5
    public static int worstMovie2018(int[][] ratings) {
        int movieTotal = 0;
        
        int [] moviesum    = new int[ratings[0].length]; 

        for(int col = 0; col < ratings[0].length; col++){
            movieTotal = 0;
            for(int row = 0; row < ratings.length; row++){
                movieTotal += ratings[row][col];
            }
            moviesum[col] = movieTotal;
        }
        
        //  loop through the moviesum 1-D array and see which movie has lowest review
        int lowMoviePos = -1;
        int lowMovieSum = 999;
        for (int i = 0; i < moviesum.length; i++) {
            if (i == 0 || moviesum[i] < lowMovieSum) {
                lowMoviePos = i;
                lowMovieSum = moviesum[i];
            }
        }
        
        return lowMoviePos;
    }
       
}  
