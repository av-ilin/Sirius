package ru.lglass.sirius

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class ReviewsRecyclerAdapter(private val reviews: List<ReviewModel>) : RecyclerView
.Adapter<ReviewsRecyclerAdapter.ReviewsViewHolder>() {

    class ReviewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val civImg: CircleImageView = itemView.findViewById(R.id.userImage)
        val tvName: TextView = itemView.findViewById(R.id.tvReviewName)
        val tvDate: TextView = itemView.findViewById(R.id.tvReviewDate)
        val tvReview: TextView = itemView.findViewById(R.id.tvReviewMessage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_reviews_item, parent, false)
        return ReviewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {
        Picasso.get().load(reviews[position].userImage).into(holder.civImg)
        holder.tvName.text = reviews[position].userName
        holder.tvDate.text = reviews[position].date
        holder.tvReview.text = reviews[position].message
    }

    override fun getItemCount() = reviews.size
}