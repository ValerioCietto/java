public class Calculator { 

  // constant values 
  public static final int NONE = -1; 
  public static final int ADD = 0; 
  public static final int SUBTRACT = 1; 
  public static final int MULTIPLY = 2; 
  public static final int DIVIDE = 3; 

  // values to be stored in the calculator memory 
  private double leftValue = 0.0; 
  private double rightValue = 0.0; 
  private int lastOperation = NONE; 
  private double multiplier = 1; 
  private boolean DOT = false; 

  // the user hits the + button 
  public double add () { 
    lastOperation = ADD; 
    resetDOT(); 
    return leftValue; 
  } 

  // the user hits the - button 
  public double subtract () { 
    lastOperation = SUBTRACT; 
    resetDOT(); 
    return leftValue; 
  } 

  // the user hits the * button 
  public double multiply () { 
    lastOperation = MULTIPLY; 
    resetDOT(); 
    return leftValue; 
  } 

  // the user hits the / button 
  public double divide () { 
    lastOperation = DIVIDE; 
    resetDOT(); 
    return leftValue; 
  } 

  // the user hits the = button 
  public double equate () { 
    switch (lastOperation) { 
      case NONE: break; 
      case ADD: leftValue = leftValue + rightValue; break; 
      case SUBTRACT: leftValue = leftValue - rightValue; break; 
      case MULTIPLY: leftValue = leftValue * rightValue; break; 
      case DIVIDE: leftValue = leftValue / rightValue; break; 
    } 
    rightValue = 0; 
    resetDOT(); 
    return leftValue; 
  } 

  // the user hits the 0-9 button 
  public double number (int i) { 
    double j = i * multiplier; 
    if (DOT) { 
      multiplier = multiplier / 10; 
    } 
    if (lastOperation == NONE) { 
      leftValue = leftValue * (DOT ? 1 : 10) + (leftValue < 0 ? (-j) : j); 
      return leftValue; 
    } else { 
      rightValue = rightValue * (DOT ? 1 : 10) + (rightValue < 0 ? (-j) : j); 
      return rightValue; 
    } 
  } 

  // the user hits the +/- button 
  public double plusMinus () { 
    if (lastOperation == NONE) { 
      leftValue = -leftValue; 
      return leftValue; 
    } else { 
      rightValue = -rightValue; 
      return rightValue; 
    } 
  } 

  // the user hits the C button 
  public double reset () { 
    lastOperation = NONE; 
    leftValue = rightValue = 0; 
    resetDOT(); 
    return leftValue; 
  } 

  // the user hits the sqrt button 
  public double sqrt () { 
    resetDOT(); 
    if (lastOperation == NONE) { 
      leftValue = Math.sqrt (leftValue); 
      return leftValue; 
    } else { 
      rightValue = Math.sqrt (rightValue); 
      return rightValue; 
    } 
  } 

  // to reset the DOT & multiplier 
  private void resetDOT() { 
    DOT = false; 
    multiplier = 1; 
  } 

  // the user hits the . button 
  public double dot () { 
    if (!DOT) { 
      DOT = true; 
      multiplier = 0.1; 
    } 
    return lastOperation == NONE ? leftValue : rightValue; 
  } 
} 
