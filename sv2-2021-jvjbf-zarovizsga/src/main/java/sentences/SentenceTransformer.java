package sentences;

public class SentenceTransformer {
    public String shortenSentence(String sentence) {
        String shortSentence = sentence;

        char[] sentenceCharacters = sentence.toCharArray();
        char firstChar = sentenceCharacters[0];
        char lastChar = sentenceCharacters[sentence.length()-1];

        if(!Character.isUpperCase(firstChar)) throw new IllegalArgumentException("Must start with capital letter!");

        if((lastChar == '.') || (lastChar == '!') || (lastChar == '?')) {
            String[] arrayOfWords = sentence.split(" ");
            if(arrayOfWords.length > 4) shortSentence = arrayOfWords[0] + " ... " + arrayOfWords[arrayOfWords.length-1];
        } else {
                throw new IllegalArgumentException("Must end with . ! or ?");
        }

        return shortSentence;
    }
}
