package com.example.praktika


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.praktika.databinding.ActivityMainBinding
import dto.Post
import viewmodel.PostViewModel
import viewmodel.viewModels


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                textView2.text = post.textView2
                textView4.text = post.textView4
                textView.text = post.textView
                if (post.likedByMe) {
                    imageButton17?.setImageResource(R.drawable.heart_red)
                }
                textView5?.text = post.likes.toString()

                root.setOnClickListener {
                    Log.d("stuff", "stuff")
                }

                imageView.setOnClickListener {
                    Log.d("stuff", "avatar")
                }

                imageButton17?.setOnClickListener {
                    Log.d("stuff", "like")
                    post.likedByMe = !post.likedByMe
                    imageButton17.setImageResource(
                        if (post.likedByMe) R.drawable.heart_red else R.drawable.heart_ser
                    )
                    if (post.likedByMe) post.likes++ else post.likes--
                    textView5?.text = post.likes.toString()
                }
                with(binding) {
                    textView2.text = post.textView2
                    textView4.text = post.textView4
                    textView.text = post.textView
                    if (post.shareByMe) {
                        imageButton15?.setImageResource(R.drawable.ic_menu_share)
                    }
                    textView6?.text = post.share.toString()

                    root.setOnClickListener {
                        Log.d("stuff", "stuff")
                    }

                    imageView.setOnClickListener {
                        Log.d("stuff", "avatar")
                    }
                    imageButton15?.setOnClickListener {
                        Log.d("stuff", "share")
                        post.shareByMe = !post.shareByMe
                        imageButton17.setImageResource(
                            if (post.shareByMe) R.drawable.ic_menu_share else R.drawable.ic_menu_share
                        )
                        if (post.shareByMe) post.share++ else post.share--
                        textView6?.text = post.share.toString()
                    }
                }


            }
        }
    }
    }