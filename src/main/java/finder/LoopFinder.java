package finder;

import model.Node;

/**
 * Created by rahul on 4/10/16.
 */
public interface LoopFinder {
    Node getLoopStartNodeElseNull() throws NullPointerException;
}
