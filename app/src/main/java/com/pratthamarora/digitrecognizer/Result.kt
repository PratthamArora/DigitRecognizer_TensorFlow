package com.pratthamarora.digitrecognizer

class Result(probs: FloatArray, timeCost: Long) {
    val number: Int
    val probability: Float
    val timeCost: Long

    companion object {
        private fun argmax(probs: FloatArray): Int {
            var maxIdx = -1
            var maxProb = 0.0f
            for (i in probs.indices) {
                if (probs[i] > maxProb) {
                    maxProb = probs[i]
                    maxIdx = i
                }
            }
            return maxIdx
        }
    }

    init {
        number = argmax(probs)
        probability = probs[number]
        this.timeCost = timeCost
    }
}
