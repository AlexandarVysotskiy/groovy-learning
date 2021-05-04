package second

class TraverseResult {

    String name
    int quantity
    double size

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        TraverseResult that = (TraverseResult) o

        if (quantity != that.quantity) return false
        if (name != that.name) return false

        return true
    }

    int hashCode() {
        int result
        result = (name != null ? name.hashCode() : 0)
        result = 31 * result + quantity
        return result
    }
}
