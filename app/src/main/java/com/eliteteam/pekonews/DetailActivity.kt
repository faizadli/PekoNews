package com.eliteteam.pekonews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.eliteteam.pekonews.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val NEWS_DATA = "news"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataRecipes = intent.getParcelableExtra<News>(NEWS_DATA) as News

        Glide.with(this).load(dataRecipes.photo).into(binding.imgDetail)

        binding.apply {
            txtDescTitle.text = dataRecipes.name
            paragrafCv.text = dataRecipes.description
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}