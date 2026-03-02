package com.exemplo.meuappcores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.graphics.Color

class MainActivity : AppCompatActivity() {

    // Referências para os componentes do layout
    private lateinit var rootLayout: LinearLayout
    private lateinit var buttonMudarCor: Button

    // Lista de cores suaves em formato hexadecimal (5 cores para alternar)
    private val coresSuaves = listOf(
        "#FFCDD2", // Vermelho claro
        "#C8E6C9", // Verde claro
        "#BBDEFB", // Azul claro
        "#FFF9C4", // Amarelo claro
        "#D1C4E9"  // Roxo claro
    )

    // Índice que controla qual cor está sendo usada no momento
    private var indiceCorAtual = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa as referências com os IDs definidos no XML
        rootLayout = findViewById(R.id.rootLayout)
        buttonMudarCor = findViewById(R.id.buttonMudarCor)

        // Define o que acontece quando o botão é clicado
        buttonMudarCor.setOnClickListener {
            mudarCorDeFundo()  // Chama a função que troca a cor
        }
    }

    /**
     * Função simples que altera a cor de fundo do LinearLayout principal.
     * A cada clique, avança para a próxima cor da lista, voltando ao início quando chegar ao final.
     */
    private fun mudarCorDeFundo() {
        // Pega a cor atual com base no índice
        val corAtual = coresSuaves[indiceCorAtual]

        // Aplica a cor ao fundo do rootLayout
        rootLayout.setBackgroundColor(Color.parseColor(corAtual))

        // Atualiza o índice para a próxima posição (de forma circular)
        indiceCorAtual = (indiceCorAtual + 1) % coresSuaves.size
    }
}