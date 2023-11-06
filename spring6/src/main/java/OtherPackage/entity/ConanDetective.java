package OtherPackage.entity;

import org.springframework.stereotype.Component;

@Component
public class ConanDetective implements Book{
    @Override
    public String getAuthor() {
        return "Aoyama Gōshō";
    }
}
