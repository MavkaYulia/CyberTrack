package com.example.cybertrack.omboarding

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.cybertrack.R


class OnBoardingFragment : Fragment(R.layout.fragment_on_boarding) {


    private val onBoardingAdapter = OnBoardingAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpOnBoarding()
        initViews()
    }

    private fun initViews() {

        val onBoarding = view?.findViewById<ViewPager2>(R.id.onboarding_view_pager)

        onBoarding?.setPageTransformer { _, _ -> onSwipePage() }

    }


    private fun onSwipePage() {
        val dot1 = view?.findViewById<AppCompatImageView>(R.id.page_1_dot)
        val dot2 = view?.findViewById<AppCompatImageView>(R.id.page_2_dot)
        val dot3 = view?.findViewById<AppCompatImageView>(R.id.page_3_dot)
        val onBoarding = view?.findViewById<ViewPager2>(R.id.onboarding_view_pager)

        val viewPagerDots = arrayOf(dot1, dot2, dot3)

        viewPagerDots.forEachIndexed { index, view ->
            if (index == onBoarding?.currentItem) {
                view?.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.purple_700
                    )
                )
            } else {
                view?.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.teal_200
                    )
                )
            }
        }
    }

    private fun setUpOnBoarding() {
        val onBoarding = view?.findViewById<ViewPager2>(R.id.onboarding_view_pager)

        onBoardingAdapter.item.add(
            Triple(
                R.drawable.imege_one,
                resources.getString(R.string.onboarding_first_title),
                resources.getString(R.string.onboarding_description)
            )
        )
        onBoardingAdapter.item.add(
            Triple(
                R.drawable.image_two,
                resources.getString(R.string.onboarding_first_title),
                resources.getString(R.string.onboarding_description)
            )
        )
        onBoardingAdapter.item.add(
            Triple(
                R.drawable.image_three,
                resources.getString(R.string.onboarding_first_title),
                resources.getString(R.string.onboarding_description)
            )
        )
        onBoarding?.adapter = onBoardingAdapter
    }
}