import java.util.PriorityQueue

/*

BASIC INFO i have CREATING SOME Fun's SO that it will be easy to
read the code

I am Using the PriorityQueue here to keep track of the meetings
 */

fun main() {
    val intervals = arrayOf(
        intArrayOf(0, 30),
        intArrayOf(5, 10),
        intArrayOf(15, 20)
    )

    println("Minimum Days Needed: ${minMeetingDays(intervals)}")
}


fun minMeetingDays(intervals: Array<IntArray>): Int {
    if (intervals.isEmpty()) return 0

    // Sorting The Neething by the start TIME
    intervals.sortBy { it[0] }

    val onGoingMeet = PriorityQueue<Int>()

    //RUNNING a Loop to CHECK TO use the Current Day or NOT
    for (meeting in intervals) {
        val start = meeting[0]
        val end = meeting[1]
        //FOR DEEBUGGING
        println("New Meeting: [$start, $end]")

        if (onGoingMeet.isNotEmpty() && canUseCurrentDay(start, onGoingMeet.peek())) {
            println("Can use current day. Freeing slot ending at ${onGoingMeet.peek()}")
            useCurrentDay(onGoingMeet)
        } else { println("Creating new day for meeting [$start, $end]") }

        createNewDay(onGoingMeet, end)
        println("Ongoing Meetings (End Times): $onGoingMeet\n")
    }

    return onGoingMeet.size //Returing THe Total Days
}


fun canUseCurrentDay(mStart: Int, earliestEnd: Int): Boolean {
    return mStart >= earliestEnd
}

fun useCurrentDay(heap: PriorityQueue<Int>) {
    heap.poll() // Removeing the earliest-ending meeting
}

fun createNewDay(heap: PriorityQueue<Int>, meetingEnd: Int) {
    heap.offer(meetingEnd) // Added current meeting's end time to Queue
}
