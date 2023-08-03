

///////////snippet for FFT


///////////////////////////////////////////////////


import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;

public class FFT {

    public static void main(String[] args) {
        // Assuming you have captured ultrasound data as an array of samples
        double[] ultrasoundData = { /* Your ultrasound data here */ };

        // Calculate the length of the data
        int n = ultrasoundData.length;

        // Perform FFT on the ultrasound data
        Complex[] fftResult = performFFT(ultrasoundData);

        // Process the FFT result (e.g., find peaks, analyze frequency content, etc.)
        processFFTResult(fftResult);
    }

    private static Complex[] performFFT(double[] data) {
        // Create an instance of the FastFourierTransformer
        FastFourierTransformer transformer = new FastFourierTransformer(DftNormalization.STANDARD);

        // Convert the data to Complex format for FFT
        Complex[] complexData = new Complex[data.length];
        for (int i = 0; i < data.length; i++) {
            complexData[i] = new Complex(data[i], 0); // Assuming the data is real-valued
        }

        // Perform the FFT
        return transformer.transform(complexData, TransformType.FORWARD);
    }

    private static void processFFTResult(Complex[] fftResult) {
        // Process the FFT result here (e.g., find peaks, analyze frequency content, etc.)
        // For example, you can print the magnitude of each frequency component
        for (int i = 0; i < fftResult.length; i++) {
            double magnitude = fftResult[i].abs();
            System.out.println("Frequency bin " + i + ": Magnitude = " + magnitude);
        }
    }
}
