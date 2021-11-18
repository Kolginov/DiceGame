package study.kolginov.dicegame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class AboutFragment : Fragment() {

    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_about, container, false)

        button=view.findViewById(R.id.button)


        button.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.remove(this)
                ?.commit()
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = AboutFragment()

    }
}