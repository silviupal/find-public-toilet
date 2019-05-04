package silviupal.findpublictoilet.firebase

/**
 * Created by Silviu Pal on 5/2/2019.
 */
data class ToiletModel(
    var id: Int,
    var city: String,
    var latitude: String, // convert in Double when using it
    var longitude: String, // convert in Double when using it
    var votesCount: Int, // increase on user click. if more than 10, the toilet is officially correct
    var downvotesCount: Int // decrease on user click. show on screen on toilet details with like button or dislike button
)