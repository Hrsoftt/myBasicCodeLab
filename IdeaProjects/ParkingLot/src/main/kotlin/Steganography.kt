import java.awt.Color
import java.io.File
import javax.imageio.ImageIO

fun main() {
    menu()
}

fun menu() {
    var cd ="n"
    while (true) {
        println("Task (hide, show, exit):")
        when (val input = readln()) {
            "hide" -> try {
                //hideimage()
            } catch (e: Exception) {
                println("Can't read input file!")
                continue
            }
            "show" -> println("Obtaining message from image.")
            "exit" -> {
                println("Bye!")
                break
            }
            else -> {
                println("Wrong task: $input")
            }
        }
    }
}

//fun hideImage() {
//    println("Input image file:")
//    val input = readln()
//    println("Output image file:")
//    val output = readln()
//    val myImage = ImageIO.read(File(input))
//    for (x in 0 until myImage.width) {
//        for (y in 0 until myImage.height) {
//            val color = Color(myImage.getRGB(x, y))
//            val colorNew = Color(
//                setLeastSignificantBitToOne(color.red),
//                setLeastSignificantBitToOne(color.green),
//                setLeastSignificantBitToOne(color.blue)
//            ).rgb
//
//            myImage.setRGB(x, y, colorNew)
//        }
//    }
//    val outputFileJpg = File(output)  // Output the file
//    ImageIO.write(myImage, "png", outputFileJpg)
//    println("Input Image: $input")
//    println("Output Image: $output")
//    println("Image $output is saved.")
//}

fun setLeastSignificantBitToOne(pixel: Int): Int = if (pixel % 2 == 0) pixel + 1 else pixel