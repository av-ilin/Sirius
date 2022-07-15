package com.sirius.test_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sirius.test_app.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_scrolling.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = DataModel()
        Picasso.get().load(data.image).into(ivImage)
        Picasso.get().load(data.logo).into(ivLogo)
        tvName.text = data.name
        rating.rating = data.rating
        tvGradeCnt.text = data.gradeCnt

        rvTags.adapter = TagsRecyclerAdapter(data.tags)
        tvDescription.text = data.description
        tvRate.text = data.rating.toString()
        barRating.rating = data.rating
        tvReviewCount.text = data.gradeCnt + " Reviews"
        when(data.reviews.size){
            0 -> rvReview.adapter = ReviewsRecyclerAdapter(listOf())
            1 -> rvReview.adapter = ReviewsRecyclerAdapter(listOf(data.reviews[0]))
            else ->
                rvReview.adapter = ReviewsRecyclerAdapter(listOf(data.reviews[0], data.reviews[1]))
        }
    }
}