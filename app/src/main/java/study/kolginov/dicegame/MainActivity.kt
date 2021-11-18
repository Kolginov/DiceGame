package study.kolginov.dicegame
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import study.kolginov.dicegame.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var binder: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)
        binder.random.setOnClickListener { rollDiceComp() }


        binder.About.setOnClickListener {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frameLayout, AboutFragment.newInstance())
                    .commit()
        }


    }

  private  fun rollDiceComp() {
        val randomValue1 = Random.nextInt(1, 6)
        binder.imageView.setImageResource(
                when (randomValue1) {
                    1 -> R.drawable.dice1
                    2 -> R.drawable.dice2
                    3 -> R.drawable.dice3
                    4 -> R.drawable.dice4
                    5 -> R.drawable.dice5
                    6 -> R.drawable.dice6
                    else -> R.drawable.dice1
                }
        )
        val randomValue2 = Random.nextInt(1, 6)
        binder.imageView2.setImageResource(
                when (randomValue2) {
                    1 -> R.drawable.dice1
                    2 -> R.drawable.dice2
                    3 -> R.drawable.dice3
                    4 -> R.drawable.dice4
                    5 -> R.drawable.dice5
                    6 -> R.drawable.dice6
                    else -> R.drawable.dice1
                }
        )
        val result = randomValue1 + randomValue2
        binder.imageView3.setImageResource(
                when (result) {
                    7, 11 -> R.drawable.win
                    2, 3, 12 -> R.drawable.loose
                    else -> R.drawable.repit
                }
        )
        when (result) {
            7, 11 -> binder.textView.text = "Ты выиграл"
            2, 3, 12 -> binder.textView.text = "Ты проиграл"
            else -> binder.textView.text = "Бросай еще"


        }
    }
}


