package videos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VideoPlatform {
    List<Channel> channels = new ArrayList<>();

    public VideoPlatform() {
        this.channels = channels;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void readDataFromFile(Path path) {
        try {
            createChannels(Files.readAllLines(path));
            System.out.println("size " + channels.size());
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot open file for read!",e);
        }
    }

    private void createChannels(List<String> lines){
        int lineNumber = 0;

        for(String line : lines){
            if(lineNumber>0){
                String[] tmp = line.split(";");
                channels.add(new Channel(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2])));
            }
            lineNumber++;
        }
    }

    public int calculateSumOfVideos() {
        int sum = 0;
        for (Channel channel: channels) {
            sum += channel.getNumber_of_videos();
        }
        return sum;
    }
}

